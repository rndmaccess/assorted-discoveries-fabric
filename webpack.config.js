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
                // Your HTML file is now the true entry point
                index: 'src/index.html',
                ...sync('src/pages/**/*.html').reduce((entries, file) => {
                    const name = path.relative('src', file).replace(/\.html$/, '');
                    entries[name] = file;
                    return entries;
                }, {}),
            },
            js: {
                // Output for any JS files found in your HTML
                filename: 'assets/js/[name].[contenthash:8].js',
            },
            css: {
                // Output for any CSS/SASS files found in your HTML
                filename: 'assets/css/[name].[contenthash:8].css',
            },
        }),
        new CopyPlugin({
            patterns: [
                { from: "src/img", to: "assets/static/img" },
            ],
        }),
    ],
    module: {
        rules: [
            {
                test: /\.(css|scss)$/,
                use: ['css-loader', 'sass-loader'], // Processes CSS and SASS
            },
            {
                test: /\.(png|jpe?g|svg|webp|ico|mp4|webm)$/i,
                type: 'asset/resource', // Handles images referenced in HTML
                generator: {
                    filename: 'assets/img/[name].[contenthash:8][ext]',
                },
            },
        ],
    },
};