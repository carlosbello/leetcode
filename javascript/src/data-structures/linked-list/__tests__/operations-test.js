const test = require('ava');
const { deleteDuplicates, deleteAllDuplicates, reverseList, mergeTwoLists, copyRandomList } = require('../operations');
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
const Node = require('../node');

const deleteDuplicatesTest = (t, deleteDuplicatesFn, givenList, expectedList) => {
    // when
    const newList = deleteDuplicatesFn(givenList);

    // expects
    t.deepEqual(newList, expectedList);
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

// @ts-ignore
test('copyRandomList returns null given null', t => {
    t.is(null, copyRandomList(null));
});
// @ts-ignore
test('copyRandomList returns single node given single node', t => {
    //given
    const head = new Node(1);
    const expectedStringRepresentation = '[[1,null]]';

    // when
    const copy = copyRandomList(head);

    t.is(head.toString(), expectedStringRepresentation);
    t.is(copy.toString(), expectedStringRepresentation);
    t.not(head, copy);
});
// @ts-ignore
test('copyRandomList returns the clone of a list with circular references', t => {
    //given
    const expectedStringRepresentation = '[[1,1],[2,1]]';
    const [n1, n2] = [new Node(1), new Node(2)];
    n1.next = n2;
    n1.random = n2;
    n2.random = n2;

    // when
    const n1Copy = copyRandomList(n1);
    const n2Copy = n1Copy.next;

    t.is(n1.toString(), expectedStringRepresentation);
    t.is(n1Copy.toString(), expectedStringRepresentation);
    t.not(n1, n1Copy);
    t.not(n2, n2Copy);
});
