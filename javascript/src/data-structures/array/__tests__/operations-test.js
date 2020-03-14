const test = require('ava');
const { transpose } = require('../operations');

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
