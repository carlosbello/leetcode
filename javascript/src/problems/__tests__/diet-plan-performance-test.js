const test = require('ava');
const dietPlanPerformance = require('../diet-plan-performance');

const dietPlanPerformanceTest = (t, givenParams, expectedPerformance) => {
    // given
    const { calories, k, lower, upper } = givenParams;

    // when
    const performance = dietPlanPerformance(calories, k, lower, upper);

    // then
    t.is(performance, expectedPerformance);
};
dietPlanPerformanceTest.title = (t, givenParams, expectedPerformance) =>
    `dietPlanPerformanceTest returns ${expectedPerformance} given ${JSON.stringify(givenParams)}`;

// @ts-ignore
test(dietPlanPerformanceTest, { calories: [1, 2, 3, 4, 5], k: 1, lower: 3, upper: 3 }, 0);
// @ts-ignore
test(dietPlanPerformanceTest, { calories: [3, 2], k: 2, lower: 0, upper: 1 }, 1);
// @ts-ignore
test(dietPlanPerformanceTest, { calories: [6, 5, 0, 0], k: 2, lower: 1, upper: 5 }, 0);
