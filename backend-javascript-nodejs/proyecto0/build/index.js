"use strict";
// 39.18
// midudev video
// https://www.youtube.com/watch?v=ZpY5KdGQvwI 
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = __importDefault(require("express"));
const diaries_1 = __importDefault(require("./routes/diaries"));
const app = (0, express_1.default)();
const PORT = 8040;
app.use(express_1.default.json());
app.use('/api/diaries', diaries_1.default);
app.get('/ping', (_req, res) => {
    console.log("alguien hizo ping ...");
    res.send("pong modificado");
});
app.listen(PORT, () => {
    console.log(`servidor en puerto ${PORT}`);
});
