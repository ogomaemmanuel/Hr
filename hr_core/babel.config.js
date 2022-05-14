let babelConfig = {
    "comments": false,
    "env": {
        "main": {
            "presets": [
                [
                    "env",
                    {
                        "targets": {
                            "node": 7
                        }
                    }
                ],
                "stage-0"
            ]
        },
        "renderer": {
            "presets": [
                [
                    "env",
                    {
                        "modules": false,
                        "targets": {
                            "browsers": [
                                "> 1%",
                                "Firefox >= 52",
                                "IE 11"
                            ],
                            "uglify": true
                        },
                        "useBuiltIns": true
                    }
                ],
                "stage-0"
            ]
        },
        "web": {
            "presets": [
                [
                    "env",
                    {
                        "modules": false,
                        "targets": {
                            "browsers": [
                                "> 1%",
                                "Firefox >= 52",
                                // last ESR
                                "IE 11"
                            ],
                            "uglify": true
                        },
                        "useBuiltIns": true
                    }
                ],
                "stage-0"
            ]
        },
        "test": {
            "presets": [
                [
                    "@babel/preset-env", {
                    targets: {
                        node: 'current',
                    },
                },]
            ]
        }
    },

    "plugins": [
        [
            "component",
            {
                "libraryName": "element-ui",
                "styleLibraryName": "theme-chalk"
            }
        ],
        "@babel/plugin-proposal-object-rest-spread",
        "transform-vue-jsx",
        "@babel/plugin-transform-runtime",
        "@babel/plugin-transform-spread",
        "@babel/plugin-syntax-dynamic-import"
    ]
}
module.exports = babelConfig;

// module.exports = {
//     presets: [
//         [
//             '@babel/preset-env',
//             {
//                 targets: {
//                     node: 'current',
//                 },
//             },
//         ],
//     ],
// };
