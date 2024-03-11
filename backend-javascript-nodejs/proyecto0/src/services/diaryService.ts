
import { DiaryEntry } from '../types';
import diaryData from './diaries.json';

const diaries: DiaryEntry[] = diaryData as DiaryEntry[];
/*
const diaries: DiaryEntry[] = [
{"id": 1, "name": "Juan perez"},
{"id": 2, "name": "Camila Monzon"},
{"id": 3, "name": "Jenny Gomez"}
]
*/

export const getEntries = ():DiaryEntry[] =>  diaries

export const getEntriesByName = ():DiaryEntry[] =>  diaries.filter( unDiario => unDiario.name == 'Camila Monzon' )

export const getEntriesByCustom = ():any[] => {
	return diaries.map(({ name }) => {
		return {
			name
		}
	})
}


export const getById = (id:number): DiaryEntry | undefined => {
	return diaries.find( unDiary => unDiary.id === id )
}


export const addEntry = (newDiary:any): any => {
	console.log(newDiary)
	return newDiary;
}

