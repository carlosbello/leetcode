const test = require('ava');
const { deleteDuplicates, deleteAllDuplicates } = require('../operations');
const ListNode = require('../list-node');

const deleteDuplicatesTest = (t, deleteDuplicatesFn, givenList, expectedList) => {
    // when
    const newList = deleteDuplicatesFn(givenList);

    // expects
    t.deepEqual(expectedList, newList);
};
deleteDuplicatesTest.title = (t, deleteDuplicatesFn, givenList, expectedList) =>
    `Test ${deleteDuplicatesFn.name} returns ${expectedList ? expectedList.toString() : null} given ${
        givenList ? givenList.toString() : null
    }`;

const list_1 = () => new ListNode(1);
const list_2 = () => new ListNode(2);
const list_1_2 = () => new ListNode(1, new ListNode(2));
const list_1_1 = () => new ListNode(1, new ListNode(1));
const list_1_1_2 = () => new ListNode(1, new ListNode(1, new ListNode(2)));
const list_1_1_2_2 = () => new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2))));

test(deleteDuplicatesTest, deleteDuplicates, null, null);
test(deleteDuplicatesTest, deleteDuplicates, list_1(), list_1());
test(deleteDuplicatesTest, deleteDuplicates, list_1_2(), list_1_2());
test(deleteDuplicatesTest, deleteDuplicates, list_1_1(), list_1());
test(deleteDuplicatesTest, deleteDuplicates, list_1_1_2(), list_1_2());
test(deleteDuplicatesTest, deleteDuplicates, list_1_1_2_2(), list_1_2());

test(deleteDuplicatesTest, deleteAllDuplicates, null, null);
test(deleteDuplicatesTest, deleteAllDuplicates, list_1(), list_1());
test(deleteDuplicatesTest, deleteAllDuplicates, list_1_2(), list_1_2());
test(deleteDuplicatesTest, deleteAllDuplicates, list_1_1(), null);
test(deleteDuplicatesTest, deleteAllDuplicates, list_1_1_2(), list_2());
test(deleteDuplicatesTest, deleteAllDuplicates, list_1_1_2_2(), null);
