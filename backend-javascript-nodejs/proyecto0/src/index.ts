
// 22.53
// midudev video


import express from 'express'
import diaryRouter from './routes/diaries'

const app = express()
const PORT = 8040

app.use(express.json())

app.use('/api/diaries', diaryRouter)

app.get('/ping', (_req, res) => {
	console.log("alguien hizo ping ...")
	res.send("hello world !")
})

app.listen(PORT, () => {
	console.log(`servidor en puerto ${PORT}`)
})

