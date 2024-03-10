
import { DiaryEntry } from '../types';
import diaryData from './diaries.json';

const diaries: Array<DiaryEntry> = diaryData as Array<DiaryEntry>;
/*
const diaries: Array<DiaryEntry> = [
{"id": 1, "name": "Juan perez"},
{"id": 2, "name": "Camila Monzon"},
{"id": 3, "name": "Jenny Gomez"}
]
*/

export const getEntries = () =>  diaries

export const addEntry = () => null;


