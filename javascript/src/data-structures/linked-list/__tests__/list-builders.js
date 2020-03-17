const ListNode = require('../list-node');

module.exports.list_1 = () => new ListNode(1);
module.exports.list_2 = () => new ListNode(2);
module.exports.list_1_2 = () => new ListNode(1, new ListNode(2));
module.exports.list_1_3 = () => new ListNode(1, new ListNode(3));
module.exports.list_2_1 = () => new ListNode(2, new ListNode(1));
module.exports.list_2_4 = () => new ListNode(2, new ListNode(4));
module.exports.list_1_1 = () => new ListNode(1, new ListNode(1));
module.exports.list_1_1_2 = () => new ListNode(1, new ListNode(1, new ListNode(2)));
module.exports.list_1_2_1 = () => new ListNode(1, new ListNode(2, new ListNode(1)));
module.exports.list_1_1_2_2 = () => new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2))));
module.exports.list_1_2_2_1 = () => new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
module.exports.list_1_2_3_4 = () => new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
