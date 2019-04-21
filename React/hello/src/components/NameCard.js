import React from 'react'

class NameCart extends React.Component {
    render() {
        const { name, number, isHuman, tags } = this.props
        return (
            <div className="alert alert-success">
                <h1>{name}</h1>
                <ui>
                    <li>电话：{number}</li>
                    <li>电话：{isHuman}</li>
                </ui>
                <hr />
                <p>
                    {
                        tags.map((tag, index) => (
                            <span key={index} className="badge badge-pill badge-primary">{tag}</span>
                        ))
                    }
                </p>
            </div>
        )
    }
}
export default NameCart