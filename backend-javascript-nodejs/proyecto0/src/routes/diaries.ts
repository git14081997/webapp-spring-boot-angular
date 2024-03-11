
import express from 'express'
import * as diaryServices from '../services/diaryService'


const router = express.Router()

router.get('/:id', (_req,res) => {
	const ans = diaryServices.getById( Number(_req.params.id) )

	// opcion1
	return (ans !== null) 
		? res.send(ans?.name) 
		: res.sendStatus(500)

	// opcion2
	if( !ans ){
		res.status(500)
		res.send("Custom response info !")
	}
	res.send( ans?.name )
})




router.get('/', (_req,res) => {
	//res.send( diaryServices.getEntries() )
	//res.send( diaryServices.getEntriesByName() )
	//res.send( diaryServices.getEntriesByCustom() )
	res.send( diaryServices.getById(1) )
})



/*
router.get('/', (_req,res) => {

	// _req.body;
	
	const localAns = {
		"msg": "fetching data about diaries ...",
		"ans": "hello world !",
		"httpStatus": 201
	}

	res.status(200)
	res.send( localAns )
})
*/


router.post('/', (_req,res) => {


	// collect some data from body
	// const { name } = _req.body

	const newEntry = diaryServices.addEntry(_req.body)

	// res.send('saving data !')
	res.json(newEntry)

})

export default router
