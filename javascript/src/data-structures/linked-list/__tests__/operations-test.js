const test = require('ava');
const { deleteDuplicates } = require('../operations');
const ListNode = require('../list-node');

const deleteDuplicatesTest = (t, givenList, expectedList) => {
    // when
    deleteDuplicates(givenList);

    // expects
    t.deepEqual(expectedList, givenList);
};
deleteDuplicatesTest.title = (t, givenList, expectedList) =>
    `Test deleteDuplicates returns ${expectedList ? expectedList.toString() : null} given ${
        givenList ? givenList.toString() : null
    }`;

test(deleteDuplicatesTest, null, null);
test(deleteDuplicatesTest, new ListNode(1), new ListNode(1));
test(deleteDuplicatesTest, new ListNode(1, new ListNode(2)), new ListNode(1, new ListNode(2)));
test(deleteDuplicatesTest, new ListNode(1, new ListNode(1)), new ListNode(1));
test(deleteDuplicatesTest, new ListNode(1, new ListNode(1, new ListNode(2))), new ListNode(1, new ListNode(2)));
test(
    deleteDuplicatesTest,
    new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2)))),
    new ListNode(1, new ListNode(2))
);
