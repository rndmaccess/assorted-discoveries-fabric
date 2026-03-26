const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
    // The entry point remains a JavaScript file
    entry: './src/index.js',
    output: {
        path: path.resolve(__dirname, 'dist'),
        filename: 'bundle.js', // Or use a hashed name like 'bundle-[hash].js'
    },
    plugins: [
        new HtmlWebpackPlugin({
            template: './src/index.html', // Specifies the HTML file to use as a template
            filename: 'index.html', // The name of the output HTML file in the 'dist' directory
            inject: 'body', // Injects script tags into the body of the HTML file
        }),
    ],
};