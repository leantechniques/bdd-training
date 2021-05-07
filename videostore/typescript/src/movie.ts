export class Movie {
  static readonly REGULAR = 1;
  static readonly NEW_RELEASE = 2;
  static readonly CHILDREN = 3;

  constructor(readonly title: string, public priceCode: number) {}
}
