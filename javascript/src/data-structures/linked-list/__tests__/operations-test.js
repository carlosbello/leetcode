const test = require('ava');
const { deleteDuplicates, deleteAllDuplicates, reverseList, mergeTwoLists } = require('../operations');
const {
    list_1,
    list_2,
    list_1_1,
    list_1_2,
    list_1_3,
    list_2_1,
    list_2_4,
    list_1_2_1,
    list_1_1_2,
    list_1_1_2_2,
    list_1_2_3_4
} = require('./list-builders');

const deleteDuplicatesTest = (t, deleteDuplicatesFn, givenList, expectedList) => {
    // when
    const newList = deleteDuplicatesFn(givenList);

    // expects
    t.deepEqual(expectedList, newList);
};
deleteDuplicatesTest.title = (t, deleteDuplicatesFn, givenList, expectedList) =>
    `${deleteDuplicatesFn.name} returns ${expectedList ? expectedList.toString() : null} given ${
        givenList ? givenList.toString() : null
    }`;

// @ts-ignore
test(deleteDuplicatesTest, deleteDuplicates, null, null);
// @ts-ignore
test(deleteDuplicatesTest, deleteDuplicates, list_1(), list_1());
// @ts-ignore
test(deleteDuplicatesTest, deleteDuplicates, list_1_2(), list_1_2());
// @ts-ignore
test(deleteDuplicatesTest, deleteDuplicates, list_1_1(), list_1());
// @ts-ignore
test(deleteDuplicatesTest, deleteDuplicates, list_1_1_2(), list_1_2());
// @ts-ignore
test(deleteDuplicatesTest, deleteDuplicates, list_1_1_2_2(), list_1_2());

// @ts-ignore
test(deleteDuplicatesTest, deleteAllDuplicates, null, null);
// @ts-ignore
test(deleteDuplicatesTest, deleteAllDuplicates, list_1(), list_1());
// @ts-ignore
test(deleteDuplicatesTest, deleteAllDuplicates, list_1_2(), list_1_2());
// @ts-ignore
test(deleteDuplicatesTest, deleteAllDuplicates, list_1_1(), null);
// @ts-ignore
test(deleteDuplicatesTest, deleteAllDuplicates, list_1_1_2(), list_2());
// @ts-ignore
test(deleteDuplicatesTest, deleteAllDuplicates, list_1_1_2_2(), null);

// @ts-ignore
test('reverseList', t => {
    t.deepEqual(null, reverseList(null));
    t.deepEqual(list_1(), reverseList(list_1()));
    t.deepEqual(list_1_2(), reverseList(list_2_1()));
    t.deepEqual(list_1_2_1(), reverseList(list_1_2_1()));
});

// @ts-ignore
test('mergeTwoLists', t => {
    t.deepEqual(null, mergeTwoLists(null, null));
    t.deepEqual(list_1(), mergeTwoLists(null, list_1()));
    t.deepEqual(list_1(), mergeTwoLists(list_1(), null));
    t.deepEqual(list_1_1(), mergeTwoLists(list_1(), list_1()));
    t.deepEqual(list_1_2(), mergeTwoLists(list_2(), list_1()));
    t.deepEqual(list_1_1_2(), mergeTwoLists(list_1_2(), list_1()));
    t.deepEqual(list_1_2_3_4(), mergeTwoLists(list_2_4(), list_1_3()));
});
