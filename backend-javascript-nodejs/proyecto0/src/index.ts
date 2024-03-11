
// 56.47 
// midudev video
// https://www.youtube.com/watch?v=ZpY5KdGQvwI 
// https://www.youtube.com/watch?v=ZpY5KdGQvwI 


import express from 'express'
import diaryRouter from './routes/diaries'

const app = express()
const PORT = 8040

// app.use(express.json())

app.use('/api/diaries', diaryRouter)

app.get('/ping', (_req, res) => {
	console.log("alguien hizo ping ...")
	res.send( "pong modificado" )
})

app.get('/pruebas', (_req, res) => {
	res.send( "pong modificado" )
})


app.listen(PORT, () => {
	console.log(`servidor en puerto ${PORT}`)
})

