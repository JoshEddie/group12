import { Outlet } from 'react-router-dom'
import Header from './Header'

import '../css/container.css'

export default function Container( {loggedInUsername, setLoggedInUsername} ) {
    return (
        <>
        <main id="container">
            <div id="headerContainer">
                <Header loggedInUsername={loggedInUsername} setLoggedInUsername={setLoggedInUsername}/>
            </div>
            <div id="outlet">
                <Outlet />
            </div>
        </main>
        </>
    )
}