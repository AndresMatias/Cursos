console.log(window);
console.log(document);

let texto='Hola mundo estoy hablando';
const hablar=(texto)=>
    speechSynthesis.speak(new SpeechSynthesisUtterance(texto));
hablar(texto);