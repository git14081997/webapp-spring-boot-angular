
export type Weather = "Sunny" | "Rainy" | "Cloudy"

// Weather se parece a unos string especificos
// Se puede usar como tipo donde va number o string

export interface DiaryEntry {
	id: number,
	name: string,
}

export interface SpecialDiary extends DiaryEntry {
	clima: Weather,	
}
