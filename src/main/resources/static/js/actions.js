var elements = document.getElementsByClassName("questionButtons");

var changeQuestionContent = function changeQuestionContent(event) {
	var buttonID = event.target.id.substring(8);
	console.log(buttonID);
};

for (var i=0; i < elements.length; i ++){
	elements[i].addEventListener('click', changeQuestionContent, false)
};