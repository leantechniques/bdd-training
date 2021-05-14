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
1. Go to Debug tab and select "Debug Gilded Rose" and then hit the green Play button

# Project/Ecosystem Overview

- **package.json** - Used by Node to manage packages and scripts (such as `npm test` mentioned above)
- **TypeScript** - Syntactic superset of JavaScript (almost all valid JavaScript is valid TypeScript). Adds static types and other features to JavaScript. Compiles down to JavaScript in order to execute the code. Configured using a `tsconfig.json`.
- **Jest** - JavaScript testing framework with a test runner, mocking, assertions, code coverage, watch mode, and more.

# Gilded Rose Kata

Hi and welcome to team Gilded Rose. As you know, we are a small inn with a prime location in a
prominent city ran by a friendly innkeeper named Allison. We also buy and sell only the finest goods.
Unfortunately, our goods are constantly degrading in quality as they approach their sell by date. We
have a system in place that updates our inventory for us. It was developed by a no-nonsense type named
Leeroy, who has moved on to new adventures. Your task is to add the new feature to our system so that
we can begin selling a new category of items. First an introduction to our system:

    - All items have a SellIn value which denotes the number of days we have to sell the item
    - All items have a Quality value which denotes how valuable the item is
    - At the end of each day our system lowers both values for every item

Pretty simple, right? Well this is where it gets interesting:

    - Once the sell by date has passed, Quality degrades twice as fast
    - The Quality of an item is never negative
    - "Aged Brie" actually increases in Quality the older it gets
    - The Quality of an item is never more than 50
    - "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    - "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
    Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
    Quality drops to 0 after the concert

We have recently signed a supplier of conjured items. This requires an update to our system:

    - "Conjured" items degrade in Quality twice as fast as normal items

Feel free to make any changes to the UpdateQuality method and add any new code as long as everything
still works correctly. However, do not alter the Item class or Items property as those belong to the
goblin in the corner who will insta-rage and one-shot you as he doesn't believe in shared code
ownership (you can make the UpdateQuality method and Items property static if you like, we'll cover
for you).

Just for clarification, an item can never have its Quality increase above 50, however "Sulfuras" is a
legendary item and as such its Quality is 80 and it never alters.
