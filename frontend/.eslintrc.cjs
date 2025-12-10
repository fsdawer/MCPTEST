module.exports = {
  root: true,
  env: {
    browser: true,
    es2021: true,
    node: true
  },
  extends: [
    'eslint:recommended',
    'plugin:vue/vue3-recommended'
  ],
  parserOptions: {
    ecmaVersion: 'latest',
    sourceType: 'module'
  },
  rules: {
    // 오류로 처리 (PR 차단)
    'no-unused-vars': 'error',
    'no-undef': 'error',
    'no-console': 'warn',
    'no-debugger': 'error',

    // Vue 규칙
    'vue/no-unused-vars': 'error',
    'vue/no-unused-components': 'error',
    'vue/multi-word-component-names': 'off'
  }
}
