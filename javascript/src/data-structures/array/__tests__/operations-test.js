const test = require('ava');
const { transpose, setZeroes } = require('../operations');

const transposeTest = (t, givenMatrix, expectedMatrix) => {
    // when
    const transposedMatrix = transpose(givenMatrix);

    // then
    t.deepEqual(expectedMatrix, transposedMatrix);
};
transposeTest.title = (t, givenMatrix, expectedMatrix) =>
    `Test transpose returns [${expectedMatrix}] given [${givenMatrix}]`;

test(transposeTest, [], []);
test(
    transposeTest,
    [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ],
    [
        [1, 4, 7],
        [2, 5, 8],
        [3, 6, 9]
    ]
);
test(
    transposeTest,
    [
        [1, 2, 3],
        [4, 5, 6]
    ],
    [
        [1, 4],
        [2, 5],
        [3, 6]
    ]
);

const setZeroesTest = (t, givenMatrix, expectedMatrix) => {
    // when
    setZeroes(givenMatrix);

    // then
    t.deepEqual(expectedMatrix, givenMatrix);
};
setZeroesTest.title = (t, givenMatrix, expectedMatrix) =>
    `Test setZeroes returns [${expectedMatrix}] given [${givenMatrix}]`;

test(setZeroesTest, [], []);
test(
    setZeroesTest,
    [
        [1, 1, 1],
        [1, 0, 1],
        [1, 1, 1]
    ],
    [
        [1, 0, 1],
        [0, 0, 0],
        [1, 0, 1]
    ]
);
test(
    setZeroesTest,
    [
        [0, 1, 2, 0],
        [3, 4, 5, 2],
        [1, 3, 1, 5]
    ],
    [
        [0, 0, 0, 0],
        [0, 4, 5, 0],
        [0, 3, 1, 0]
    ]
);
