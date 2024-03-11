"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.addEntry = exports.getEntriesByName = exports.getEntries = void 0;
const diaries_json_1 = __importDefault(require("./diaries.json"));
const diaries = diaries_json_1.default;
/*
const diaries: DiaryEntry[] = [
{"id": 1, "name": "Juan perez"},
{"id": 2, "name": "Camila Monzon"},
{"id": 3, "name": "Jenny Gomez"}
]
*/
const getEntries = () => diaries;
exports.getEntries = getEntries;
const getEntriesByName = () => diaries.filter(unDiario => unDiario.name == 'Camila Monzon');
exports.getEntriesByName = getEntriesByName;
const addEntry = () => undefined;
exports.addEntry = addEntry;
