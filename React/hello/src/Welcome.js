import React from 'react'

class Welcome extends React.Component {
    render() {
        const tolist = ["a", "b", "c"]
        const v1 = <h1> Hello React </h1>
        console.log(v1)
        return <div>
            <a href="a"> Hello React </a>
            <ul>
                {
                    tolist.map(itme =>
                        <li>{itme}</li>
                    )
                }
            </ul>
        </div>
    }
}
export default Welcome