const test = require('ava');
const { transpose, setZeroes, duplicateZeros } = require('../operations');

const transposeTest = (t, givenMatrix, expectedMatrix) => {
    // when
    const transposedMatrix = transpose(givenMatrix);

    // then
    t.deepEqual(expectedMatrix, transposedMatrix);
};
transposeTest.title = (t, givenMatrix, expectedMatrix) =>
    `Test transpose returns [${expectedMatrix}] given [${givenMatrix}]`;

// @ts-ignore
test(transposeTest, [], []);
// @ts-ignore
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
// @ts-ignore
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

// @ts-ignore
test(setZeroesTest, [], []);
// @ts-ignore
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
// @ts-ignore
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

// @ts-ignore
test('duplicateZeros', t => {
    // given
    const givenA0 = [0, 1];
    const expectedA0 = [0, 0];
    const givenA1 = [1, 0, 2, 3, 0, 4, 5, 0];
    const expectedA1 = [1, 0, 0, 2, 3, 0, 0, 4];
    const givenA2 = [1, 2, 3];
    const expectedA2 = [1, 2, 3];

    // when
    duplicateZeros(givenA0);
    duplicateZeros(givenA1);
    duplicateZeros(givenA2);

    // then
    t.deepEqual(givenA0, expectedA0);
    t.deepEqual(givenA1, expectedA1);
    t.deepEqual(givenA2, expectedA2);
});
