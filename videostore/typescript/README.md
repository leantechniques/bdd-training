# Getting Started

1. Install NodeJS 16.1
    - [macOS installer](https://nodejs.org/dist/v16.1.0/node-v16.1.0.pkg)
        - Or... `brew install node@16.1`
    - [Windows installer](https://nodejs.org/dist/v16.1.0/node-v16.1.0-x64.msi)
    - Check your Node version at the command line via `node -v`
1. Install [VS Code](https://code.visualstudio.com/) or equivalent editor/IDE
1. `npm i` to install dependencies
1. Running tests:
   - `npm test` to run your tests without watch mode
   - `npm run test:watch` to run your tests in watch mode
   - `npm run test:coverage` to run your tests in watch and collectCoverage mode

# Debug on VS Code

> The `.vscode/launch.json` has already been committed with the necessary config to debug.

1. Set breakpoint in code
1. Go to Debug tab and select "Debug Video Store" and then hit the green Play button

# Project/Ecosystem Overview

- **package.json** - Used by Node to manage packages and scripts (such as `npm test` mentioned above)
- **TypeScript** - Syntactic superset of JavaScript (almost all valid JavaScript is valid TypeScript). Adds static types and other features to JavaScript. Compiles down to JavaScript in order to execute the code. Configured using a `tsconfig.json`.
- **Jest** - JavaScript testing framework with a test runner, mocking, assertions, code coverage, watch mode, and more.

# Video Store Requirements

Refactor Video Store. The Video Store example is from Martin Fowler's Refactoring, and from Episode 3 of cleancoders.com

Original in Java: https://github.com/unclebob/videostore
