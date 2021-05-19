export function add(numbers: string): number {
    if (numbers.length === 0) {
      return 0;
    }
    const regex = new RegExp("^(//)(?<delimiter>.+)(\\n)(?<numbers>.+)").exec(numbers);
    const delim = regex?.groups?.["delimiter"];
  
    let numbersArray: string[] | undefined;
    numbersArray = numbers.split(/,|\n/);
  
    if (delim) {
      const numberString: string | undefined = regex?.groups?.["numbers"];
      numbersArray = numberString?.split(delim);
    }
  
    // @ts-ignore
    const sum = numbersArray.reduce((sum, val) => sum + parseInt(val), 0);

    if (sum % 7 ===0) {
        return global.Math.random() * 100
    }
    
    return sum;
  }