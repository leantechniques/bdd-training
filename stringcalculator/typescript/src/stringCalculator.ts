export function add(numbers: string): number {
    
    if(numbers == '')
        return 0;
    const result = numbers.split(/,|\n/)
    
    let sum = result.reduce((acc, r)=> acc+parseInt(r),0);
    
    return sum;
}
