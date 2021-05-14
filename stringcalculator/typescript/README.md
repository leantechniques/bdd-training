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
1. Running the app with `npm start`

# Debug on VS Code

> The `.vscode/launch.json` has already been committed with the necessary config to debug.

1. Set breakpoint in code
1. Go to Debug tab and select "Debug String Calculator" and then hit the green Play button

# Project/Ecosystem Overview

- **package.json** - Used by Node to manage packages and scripts (such as `npm test` mentioned above)
- **TypeScript** - Syntactic superset of JavaScript (almost all valid JavaScript is valid TypeScript). Adds static types and other features to JavaScript. Compiles down to JavaScript in order to execute the code. Configured using a `tsconfig.json`.
- **Jest** - JavaScript testing framework with a test runner, mocking, assertions, code coverage, watch mode, and more.

# String Calculator Requirements

1. “” = 0
1. “1” = 1
1. “1,2” = 3
1. Any amount of numbers: “1,2,3,4,5,6” = 21
1. Allow newlines and commas
   - “1\n2,3” = 6
1. Allow Different Delimiters
   - “//[delimiter]\n[numbers…]”
   - “//;\n1;2;3;4;5;6” = 21
   - “//\n\n1\n2\n3\n4\n5\n6”
1. When the sum is evenly divisible by 7 or 11, return a random number between 1..100.
1. Write the value to a database each time add(..) is called.
