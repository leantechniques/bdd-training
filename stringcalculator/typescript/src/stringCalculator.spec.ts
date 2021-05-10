import { add } from "./stringCalculator"

it("should return 0 when empty string is passed", () => {
    const result = add("");
    expect(result).toEqual(0);
});
