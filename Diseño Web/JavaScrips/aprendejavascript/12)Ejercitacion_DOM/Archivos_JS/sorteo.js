//----Variables y Constantes----
const d=document;

export default function sorteo(btn,selector){
    const getWinner=(selector)=>{
        const $player=d.querySelectorAll(selector),
              random=Math.floor(Math.random()*$player.length),
              winner=$player[random];
        return `El gandor es ${winner.textContent}`;
    }
    d.addEventListener('click',e=>{
        if(e.target.matches(btn)){
            let result=getWinner(selector);
            alert(result);

        }
    });
}