export function add(numbers: string): number {
    
    if(numbers == '')
        return 0;
    const result = numbers.split(',')
    let sum = 0;
    result.forEach(r => sum += parseInt(r));
    return sum;
}
