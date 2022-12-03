const d=document;
let x=0,y=0;

export function shortcuts(e){
    if(e.key==='a' && e.altKey){

    }
}

/**
 * Funcion para mover bola
 * @param {Event} e evento de teclado
 * @param {*} ball selector de ball 
 * @param {*} stage selector de stage
 */
export function moveBall(e,ball,stage){
    //--Variables--
    const $ball=d.querySelector(ball),
          $stage=d.querySelector(stage),
          limitBall=$ball.getBoundingClientRect(),
          limitStage=$stage.getBoundingClientRect();
    switch(e.keyCode){
        case 37: //izquierda
            if(limitBall.left>limitStage.left){
                e.preventDefault(); //dentro del if para que cuando llegue al limite las teclas controlen el scroll de la pagina
                x--;   
            }
            break;
        case 38: //arriba
            
            if(limitBall.top>limitStage.top){
                e.preventDefault();
                y--;    
            }
            break;
        case 39: //derecha
            
            if(limitBall.right<limitStage.right){
                e.preventDefault();
                x++;             
            }
            break;
        case 40: //abajo
            
            if(limitBall.bottom<limitStage.bottom){
                e.preventDefault();
                y++;    
            }
            break;
        default:
            break;
    }
    $ball.style.transform=`translate(${x*10}px, ${y*10}px)`;
}