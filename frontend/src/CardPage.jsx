import React, {useEffect, useState} from 'react';

function CardPage() {
const localData =     localStorage.getItem("cart")
const [card,setCard] = useState(localData==null?[]:JSON.parse(localData))


    // useEffect(() => {
    //     setCard(localData==null?[]:JSON.parse(localData))
    // }, []);

    function plus(index) {
        card[index].productCount++
        setCard([...card])
        localStorage.setItem("cart",JSON.stringify(card));
    }

    function minus(id) {
        card.map((item,i)=>{
            if(item.id==id){
                if((item.productCount === 1)){
                    card.splice(i,1);
                }else {
                    item.productCount--;
                }
            }
        });
        setCard([...card]);
        localStorage.setItem("cart",JSON.stringify(card))
    }

    return (
        <div>
            <br/>
            <table className={"table table-bordered"}>
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                    <th>count</th>
                    <th>action</th>
                </tr>
                </thead>
                <tbody>
                {card.map((item, index) => {
                    return <tr key={item.id}>
                        <td>{index+1}</td>
                        <td>{item.name}</td>
                        <td>{item.price}</td>
                        <td>
                            <button onClick={()=>plus(index)} className={"btn btn-dark mx-1"}>+</button>
                            {item.productCount}
                            <button onClick={()=>minus(item.id)} className={"btn btn-dark mx-1"}>-</button>
                        </td>
                        <td>
                            <button className={"btn-close"}></button>
                        </td>
                    </tr>
                })}
                </tbody>
                <tfoot>
                <tr>
                    <th className={"text-end"}>Total:</th>
                    <td>{card.reduce((s,itm)=>itm.price*itm.productCount+s,0)}</td>
                </tr>
                </tfoot>
            </table>
        </div>
    );
}

export default CardPage;