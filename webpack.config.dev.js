const MiniCssExtractPlugin = require("mini-css-extract-plugin");
const BrotliGzipPlugin = require('brotli-gzip-webpack-plugin');
const path = require("path")
const webpack = require("webpack")
const HtmlWebpacktPlugin = require("html-webpack-plugin")
const bundleOutputDir = "./target/classes/static/js/dist"
const VueLoaderPlugin = require('vue-loader/lib/plugin')
const CleanWebpackPlugin = require('clean-webpack-plugin');
const SWPrecacheWebpackPlugin = require('sw-precache-webpack-plugin')


let commonConfig=
    {
        optimization: {
            // minimizer: [new UglifyJsPlugin()],
            nodeEnv: 'production',
            minimize: true,
        },
        watchOptions: {
            ignored: /node_modules/
        },
        stats: {modules: false},
        context: __dirname,
        resolve: {
            extensions: [".js", ".vue", ".css", ".scss", ".sass"],
            alias: {
                vue: 'vue/dist/vue.js',
                'bulma': "bulma/css/bulma.css"
            },


        },
        entry: {main: "./src/main/resources/static/js/src/main.js"},
        module: {
            rules: [
                {
                    test: /\.vue$/,
                    loader: "vue-loader",
                    options: {
                        loaders: {
                            // Since sass-loader (weirdly) has SCSS as its default parse mode, we map
                            // the "scss" and "sass" values for the lang attribute to the right configs here.
                            // other preprocessors should work out of the box, no loader config like this necessary.
                            scss: "vue-style-loader!css-loader!sass-loader",
                            less: "vue-style-loader!css-loader!less-loader",
                            sass: "vue-style-loader!css-loader!sass-loader?indentedSyntax",
                        }
                        // other vue-loader options go here
                    }
                },

                {
                    test: /\.js$/,
                    loader: 'babel-loader',
                    exclude: /node_modules/,
                },
                {
                    test: /\.less$/,
                    use: [
                        'vue-style-loader',
                        'css-loader',
                        'less-loader'
                    ]
                },
                {
                    test: /\.scss$/,
                    use: [
                        'vue-style-loader',
                        'css-loader',
                        'sass-loader'
                    ]
                },

                {
                    test: /\.css$/,
                    use: [
                        {
                            loader: MiniCssExtractPlugin.loader,

                        },
                        "css-loader",
                        {
                            loader: 'postcss-loader',
                            options: {
                                ident: 'postcss',
                                plugins: [
                                    require('tailwindcss'),
                                    require('autoprefixer'),
                                ],
                            }}
                    ]
                },
                {test: /.(png|jpg|jpeg|gif|svg|woff|woff2|ttf|eot)$/, use: "url-loader?limit=100000"}
            ]
        },


        plugins: [
            new CleanWebpackPlugin([bundleOutputDir]),
            new VueLoaderPlugin(),
            new MiniCssExtractPlugin({
                filename: 'main.css',
                chunkFilename: "[id].[hash].css"
            }),
            new webpack.DefinePlugin({
                'PRODUCTION': JSON.stringify(true),
            }),
            new webpack.NormalModuleReplacementPlugin(/element-ui[\/\\]lib[\/\\]locale[\/\\]lang[\/\\]zh-CN/, 'element-ui/lib/locale/lang/en'),
            new BrotliGzipPlugin({
                asset: '[path].br[query]',
                algorithm: 'brotli',
                test: /\.(js|css|html|svg)$/,
                threshold: 10240,
                minRatio: 0.8,
                quality: 11
            }),
            new webpack.ContextReplacementPlugin(/moment[/\\]locale$/, /en-Us/),
            new BrotliGzipPlugin({
                asset: '[path].gz[query]',
                algorithm: 'gzip',
                test: /\.(js|css|html|svg)$/,
                threshold: 10240,
                minRatio: 0.8
            }),
            new webpack.ProvidePlugin({
                $ : "jquery",
                jQuery : "jquery",
                moment : "moment",
                croppie:"croppie"
            })
        ]
    }

    let devConfig =Object.assign({}, commonConfig,{
        output: {
            path: path.join(__dirname, bundleOutputDir),
            filename: "[name].js",
            publicPath: "/js/dist/",
            chunkFilename: '[name].bundle.js',
        },
    });

let prodConfig=Object.assign({}, commonConfig,{
    output: {
        path: path.join(__dirname, "./src/main/resources/static/js/dist"),
        filename: "[name].js",
        publicPath: "/js/dist/",
        chunkFilename: '[name].bundle.js',
    },
});

module.exports = [
    prodConfig, devConfig,
];


