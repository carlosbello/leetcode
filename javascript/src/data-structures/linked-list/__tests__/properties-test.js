const test = require('ava');
const { isPalindrome1, isPalindrome2 } = require('../properties');
const { list_1, list_1_1, list_1_2, list_1_2_1, list_1_1_2, list_1_2_2_1, list_1_1_2_2 } = require('./list-builders');

const isPalindromeTest = (t, isPalindromeFn, givenList, expectedIsPalindrome) => {
    t.is(expectedIsPalindrome, isPalindromeFn(givenList));
};

isPalindromeTest.title = (t, isPalindromeFn, givenList, expectedIsPalindrome) =>
    `${isPalindromeFn.name} returns ${expectedIsPalindrome} given ${givenList}`;

[isPalindrome1, isPalindrome2].forEach(isPalindromeFn => {
    // @ts-ignore
    test(isPalindromeTest, isPalindromeFn, null, true);
    // @ts-ignore
    test(isPalindromeTest, isPalindromeFn, list_1(), true);
    // @ts-ignore
    test(isPalindromeTest, isPalindromeFn, list_1_1(), true);
    // @ts-ignore
    test(isPalindromeTest, isPalindromeFn, list_1_2(), false);
    // @ts-ignore
    test(isPalindromeTest, isPalindromeFn, list_1_2_1(), true);
    // @ts-ignore
    test(isPalindromeTest, isPalindromeFn, list_1_1_2(), false);
    // @ts-ignore
    test(isPalindromeTest, isPalindromeFn, list_1_2_2_1(), true);
    // @ts-ignore
    test(isPalindromeTest, isPalindromeFn, list_1_1_2_2(), false);
});
