export type Movie = {
  title: string;
  code: MovieCode;
};

export enum MovieCode {
  Regular = 1,
  NewRelease = 2,
  Children = 3,
}
