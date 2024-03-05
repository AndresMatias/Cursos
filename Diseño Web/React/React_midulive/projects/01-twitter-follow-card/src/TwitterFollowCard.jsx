import { useState } from 'react'

export function TwitterFollowCard ({ children, userName, initialIsFollowing }) {
  /*useState: Me sirve para guardar en una variable un estado, en este caso si estoy o no siguiendo a un usuario y en funcion de eso renderizar--
    useState: me devuelve dos elementos
              isFollowing: seria como el estado actual, es un valor NO UNA FUNCION
              setIsFollowing: seria como el interruptor de luz del ejemplo, en este caso es una funcion que me permite actualizar el estado
  */
  const [isFollowing, setIsFollowing] = useState(initialIsFollowing) //initialIsFollowing: solo se inicializa UNA VEZ, por mas que le vuevla a pasar otros valores luego de inicializado el componentes NO VA A CAMBIAR

  console.log('[TwitterFollowCard] render with userName: ', userName)

  const text = isFollowing ? 'Siguiendo' : 'Seguir'
  //--Condicional if para agregar clase a css--
  const buttonClassName = isFollowing
    ? 'tw-followCard-button is-following'
    : 'tw-followCard-button'

  //--Evento Click--
  const handleClick = () => { // Si sucede el evento de click
    setIsFollowing(!isFollowing) // Funcion para actualizar el estado y que luego se renderiza
  }

  return (
    <article className='tw-followCard'>
      <header className='tw-followCard-header'>
        <img
          className='tw-followCard-avatar'
          alt='El avatar de midudev'
          src={`https://unavatar.io/${userName}`}
        />
        <div className='tw-followCard-info'>
          <strong>{children/*Children es un hijo y prop de react: Recupero Nombre entre  </TwitterFollowCard> name}</TwitterFollowCard>*/}</strong> 
          <span className='tw-followCard-infoUserName'>@{userName}</span>
        </div>
      </header>

      <aside>
        <button className={buttonClassName} /*NO uso AddEventListener debido a la naturaleza declarativa en vez imperativa de react*/onClick={handleClick}>
          <span className='tw-followCard-text'>{text}</span>
          <span className='tw-followCard-stopFollow'>Dejar de seguir</span>
        </button>
      </aside>
    </article>
  )
}
