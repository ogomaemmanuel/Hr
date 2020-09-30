module.exports = {
    "globals": {
        "ts-jest": {
            "tsConfig": "tsconfig.json",
            "diagnostics": true
        }
    },
    "roots": [
        "<rootDir>/src/main/resources/static/js"
    ],
    "moduleNameMapper": {
        "^vue$": "vue/dist/vue.common.js"
    },
    "moduleFileExtensions": [
        "js",
        "vue",
        "ts",
        "json"
    ],
    "transform": {
        ".+\\.tsx?$": "babel-jest",
        ".*\\.(vue)$": "vue-jest",
        ".+\\.jsx?$": "babel-jest"
    },
    "transformIgnorePatterns": [
        "/node_modules/(?!vue-sweetalert2).+\\.js$"
    ]
}