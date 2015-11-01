package vndict

import com.vnstreaming.DictEnVi

import grails.converters.JSON
import grails.util.Holders;

class ApiController {

    def index() { 
		render "vndict version : "+Holders.config.version
	}
	
	def searchEV(){
		def word = params.word;
		if(word){
			def fWord = DictEnVi.findByWord(word)
			if(fWord){
				render(status:200, contentType: "text/json") {
				    result(phonetic: fWord.phonetic, meanings: fWord.meanings)
				}
				return
			}
		}
		render (status:200,"Word not found")
	}
}
