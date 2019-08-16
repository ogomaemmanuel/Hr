const MiniCssExtractPlugin = require("mini-css-extract-plugin");
const path = require("path")
const webpack = require("webpack")
const ExtractTextPlugin = require("extract-text-webpack-plugin")
const BundleAnalyzerPlugin = require('webpack-bundle-analyzer')
    .BundleAnalyzerPlugin;
const HtmlWebpacktPlugin = require("html-webpack-plugin")
const bundleOutputDir = "./target/classes/static/js/dist"
const VueLoaderPlugin = require('vue-loader/lib/plugin')
const CleanWebpackPlugin = require('clean-webpack-plugin');
module.exports = env => {
    const isDevBuild = !(env && env.prod)

    return [
        {
            // watch: true,
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
                }
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
                                hotReload: true
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
                    }, {
                        test: /\.scss$/,
                        use: [
                            'vue-style-loader',
                            'css-loader',
                            'sass-loader'
                        ]
                    },

                    {
                        test: /\.css$/,
                        use: isDevBuild
                            ? ["style-loader", "css-loader"]
                            : ExtractTextPlugin.extract({use: "css-loader?minimize"})
                    },
                    {test: /.(png|jpg|jpeg|gif|svg|woff|woff2|ttf|eot)$/, use: "url-loader?limit=100000"}
                ]
            },
            output: {
                path: path.join(__dirname, bundleOutputDir),
                filename: "[name].js",
                publicPath: "/js/dist/",
                chunkFilename: '[name].bundle.js',
                globalObject: 'this'
            },
            devtool: 'inline-source-map',
            watchOptions: {
                aggregateTimeout: 300,
                poll: 1000
            },
            devServer: {
                // contentBase: bundleOutputDir,
                hot: true,
                inline: true,
                port:9080,
                disableHostCheck: true,
                proxy: {
                    '/**': {
                        target: 'http://localhost:49612',
                        secure: false,
                        // <a href="https://github.com/nodejitsu/node-http-proxy">node-http-proxy</a> option - don't add /localhost:8080/ to proxied request paths
                        prependPath: false
                    },
                },
                open: true,
                publicPath: "/js/dist/"

            },
            plugins: [
                new CleanWebpackPlugin([bundleOutputDir]),
                new HtmlWebpacktPlugin({
                    title: "hot module replacement"
                }),

                new webpack.DefinePlugin({
                    'PRODUCTION': JSON.stringify(false),
                }),
                // new BundleAnalyzerPlugin(),
                //  new webpack.HotModuleReplacementPlugin(),
                new webpack.NormalModuleReplacementPlugin(/element-ui[\/\\]lib[\/\\]locale[\/\\]lang[\/\\]zh-CN/, 'element-ui/lib/locale/lang/en'),

                new VueLoaderPlugin(),
                new webpack.ContextReplacementPlugin(/moment[/\\]locale$/, /en-Us/),
                new webpack.DefinePlugin({
                    "process.env": {
                        NODE_ENV: JSON.stringify(isDevBuild ? "development" : "production")
                    }
                }),
                new webpack.ProvidePlugin({
                    $ : "jquery",
                    jQuery : "jquery",
                    moment : "moment",
                    croppie:"croppie"
                })
            ].concat(
                isDevBuild
                    ? [
                        // Plugins that apply in development builds only
                        new webpack.SourceMapDevToolPlugin({
                            filename: "[file].map", // Remove this line if you prefer inline source maps
                            moduleFilenameTemplate: path.relative(
                                bundleOutputDir,
                                "[resourcePath]"
                            ) // Point sourcemap entries to the original file locations on disk
                        })
                    ]
                    : [
                        // Plugins that apply in production builds only
                        new webpack.optimize.UglifyJsPlugin(),
                        new ExtractTextPlugin("site.css")
                    ]
            )
        }
    ]
}
