const test = require('ava');
const { gcdOfStrings } = require('../operations');

// @ts-ignore
test('gcdOfStrings', t => {
    t.is(gcdOfStrings('', ''), '');
    t.is(gcdOfStrings('ABCABC', 'ABC'), 'ABC');
    t.is(gcdOfStrings('ABABAB', 'ABAB'), 'AB');
    t.is(gcdOfStrings('LEET', 'CODE'), '');
});
