var webpack = require('webpack');
var path = require('path');
var autoprefixer = require('autoprefixer');

var BUILD_DIR = path.resolve(__dirname, './build');
var APP_DIR = path.resolve(__dirname, './src');

if (global.Promise == null) {
    global.Promise = require('es6-promise');
}

var config = {
    devtool: 'eval',
    entry: [
        'whatwg-fetch',
        'webpack-dev-server/client?http://localhost:9090',
        'webpack/hot/only-dev-server',
        APP_DIR + '/index'
    ],
    output: {
        path: BUILD_DIR,
        filename: 'bundle.js',
        publicPath: '/static/'
    },
    plugins: [
        new webpack.HotModuleReplacementPlugin()
    ],
    module: {
        loaders: [
            {
                test: /\.jsx?/,
                include: APP_DIR,
                loaders: [
                    'react-hot',
                    'babel'
                ]
            },
            {
                test: /\.scss$/,
                include: APP_DIR,
                loaders: [
                    'style',
                    'css',
                    'postcss',
                    'sass?outputStyle=expanded'
                ]
            }
        ]
    },
    postcss: [ autoprefixer({ browsers: ['last 2 versions'] }) ],
    devServer: {
        hot: true,
        contentBase: BUILD_DIR
    }
};

module.exports = config;
