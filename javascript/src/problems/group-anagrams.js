/**
 * 49. Group Anagrams [medium] https://leetcode.com/problems/group-anagrams/
 * 
 * @param {string[]} strs
 * @return {string[][]}
 */
const groupAnagrams = strs => {
    const hash = word => word.split('').sort().join('');
    const anagramMap = new Map();
    for(let word of strs) {
        let wordHash = hash(word);
        if (!anagramMap.has(wordHash)) {
            anagramMap.set(wordHash, []);
        }
        anagramMap.get(wordHash).push(word);
    }
    return Array.from(anagramMap.values())
        .map(arr => arr.sort())
        .sort((a1, a2) => a1.length - a2.length);
};

module.exports = { groupAnagrams };
