export type RecordsResponse = {
    content: Recorditem[];
    totalPages: number;
}

export type Recorditem = {
    id: number;
    moment: string;
    name: string;
    age: number;
    gameTitle: string;
    gamePlatform: Platform;
    genreName: string;
}

export type Platform = 'XBOX' | 'PC' | 'PLAYSTATION';