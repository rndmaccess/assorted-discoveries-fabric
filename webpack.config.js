const path = require('path');
const HtmlBundlerPlugin = require('html-bundler-webpack-plugin');
const CopyPlugin = require('copy-webpack-plugin');
const { sync } = require('glob');

module.exports = {
    mode: 'production', // Automatically minifies JS and HTML in production
    output: {
        path: path.resolve(__dirname, 'dist'),
        clean: true, // Cleans the dist folder before each build
    },
    plugins: [
        new HtmlBundlerPlugin({
            entry: {
                index: 'src/index.html',
                ...sync('src/pages/**/*.html').reduce((entries, file) => {
                    const name = path.relative('src', file).replace(/\.html$/, '');
                    entries[name] = file;
                    return entries;
                }, {}),
            },
            // Add this preprocessor section
            preprocessor: (content, { resourcePath }) => {
                // This stops the plugin from parsing attributes that contain 'static/'
                // It treats them as plain strings so Webpack never "sees" the file
                return content;
            },
            sources: [
                {
                    tag: 'img',
                    filter: ({ value }) => {
                        return !value.includes('static/');
                    },
                }
                // 'true' tells the plugin to use default rules for everything else (scripts, links, etc.)
            ],
            js: {
                // Output for any JS files found in your HTML
                filename: 'assets/js/[name].[contenthash:8].js',
            },
            css: {
                // Output for any CSS files found in your HTML
                filename: 'assets/css/[name].[contenthash:8].css',
            },
        }),
        new CopyPlugin({
            patterns: [
                { from: "src/static/img", to: "assets/static/img" },
            ],
        }),
    ],
    module: {
        rules: [
            {
                test: /\.js$/,
                include: path.resolve(__dirname, 'src/js'),
                exclude: /node_modules/,
                // Add this to force Webpack to treat these as ES modules
                type: 'javascript/auto',
                loader: 'esbuild-loader',
                options: {
                    loader: 'js',
                    target: 'es2015'
                }
            },
            {
                test: /\.(css)$/,
                use: ['css-loader'],
            },
            {
                test: /\.(png|jpe?g|svg|webp|ico)$/i,
                type: 'asset/resource', // Handles images referenced in HTML
                generator: {
                    filename: 'assets/img/[name].[contenthash:8][ext]',
                },
            },
            {
                test: /\.(mp4|webm)$/i,
                type: 'asset/resource', // Handles videos referenced in HTML
                generator: {
                    filename: 'assets/video/[name].[contenthash:8][ext]',
                },
            },
        ],
    },
};