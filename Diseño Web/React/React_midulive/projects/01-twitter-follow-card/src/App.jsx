import './App.css'
import { TwitterFollowCard } from './TwitterFollowCard.jsx'

const users = [
  {
    userName: 'midudev',
    name: 'Miguel Ángel Durán',
    isFollowing: true
  },
  {
    userName: 'pheralb',
    name: 'Pablo H.',
    isFollowing: false
  },
  {
    userName: 'PacoHdezs',
    name: 'Paco Hdez',
    isFollowing: true
  },
  {
    userName: 'TMChein',
    name: 'Tomas',
    isFollowing: false
  }
]
//No se recomienda usar comentarios dentro del return donde pongo lo que se va a renderizar, en este caso lo hago porque es un ejemplo para explciarme ami mismo
export function App () {
  return (
    <section className='App'> 
      {
        users.map(({ userName, name, isFollowing }) => (
          <TwitterFollowCard
            key={userName /*Key: es propio de react para que react identifique el elemento(tiene que ser algo unico) por mas que mi clase no lo tenga en los argumentos en este caso lo identifico con el nombre */}
            userName={userName}
            initialIsFollowing={isFollowing}
          >
            {name}
          </TwitterFollowCard>
        ))
      }
    </section>
  )
}
