/**
 * 1071. Greatest Common Divisor of Strings [easy] https://leetcode.com/problems/greatest-common-divisor-of-strings/
 *
 * @param {String} str1
 * @param {String} str2
 * @returns {String}
 */
const gcdOfStrings = (str1, str2) => {
    if (str1.length === str2.length) {
        return str1 === str2 ? str1 : '';
    }
    if (str2.length > str1.length) {
        [str1, str2] = [str2, str1];
    }
    if (str1.substr(0, str2.length) === str2) {
        return gcdOfStrings(str2, str1.substr(str2.length));
    }
    return '';
};

module.exports = { gcdOfStrings };
