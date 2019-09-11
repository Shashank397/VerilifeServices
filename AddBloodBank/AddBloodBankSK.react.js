import React from 'react';
import axios  from 'axios';

import './DonorRegister.css';
const proxyurl = "https://cors-anywhere.herokuapp.com/"
let url1="http://localhost:1015/addBloodBank";
let url = proxyurl + url1;
class DonorRegister extends React.Component {
    constructor(props) {
        super(props);
        this.state={
       newdonorList:{
        "blood_bank_id":0,
        "blood_bank_name":"",
        "phone_number":0,
        "city":"",
        "state":"",
        "country":"",
        "pincode":0,
        "address":"",
        "email":"",
        "effective_date":"",
        "opos":"",
        "oneg":"",
        "apos":"",
        "aneg":"",
        "bpos":"",
        "bneg":"",
        "abpos":"",
        "abneg":"",
    }
        }
    }


    handleChange =(event) =>{
       
        let name = event.target.name;
        let value =event.target.value;
         // console.log(value)
          this.setState(prevState =>( {newdonorList:{...prevState.newdonorList,[name]:value}}));
          //console.log("This is : " + JSON.stringify(this.state.newdonorList))
      }

      handleSubmit =(event) =>
      {
 
          event.preventDefault();
          console.log(this.state.newdonorList);
        //   axios.post(url1,this.state.newdonorList,headers)
         fetch(url1,{
            "method":"POST",
            "body":JSON.stringify(this.state.newdonorList),
            headers:{
                "Content-Type":"application/json"
            },
        })
        .then(resp=>{ console.log(resp);console.log(resp.status)});
      }
    render() {
        return (
            <div className='addbloodbank_wrapper'>
            <h1>Blood Bank Registeration</h1>
         <form className="form1" onSubmit={this.handleSubmit}>
         <label>
            Name:
         <input type="text" name="blood_bank_name" onChange={this.handleChange}/>
         </label><br></br>
         <label>
            Phone Number:
         <input type="number" name="phone_number" onChange={this.handleChange} />
         </label><br></br>
         <label>
            Email:
         <input type="email" name="email" onChange={this.handleChange}/>
         </label><br></br>
         <label>
            Local Address:
         <input type="text" name="address" onChange={this.handleChange}/>
         </label><br></br>
         <label>
            Pincode:
         <input type="text" name="pincode" onChange={this.handleChange}/>
         </label><br></br>
         <label>
            City:
         <input type="text" name="city" onChange={this.handleChange}/>
         </label><br></br>
         <label>
            State:
         <input type="text" name="state" onChange={this.handleChange}/>
         </label><br></br>
         <label>
            Country:
         <input type="text" name="country" onChange={this.handleChange}/>
         </label><br></br>
         <label>
            ONeg Availability:
         <input type="number" name="oneg" onChange={this.handleChange}/>
         </label><br></br>
         <label>
            OPoz Availability:
         <input type="number" name="opos" onChange={this.handleChange} />
         </label><br></br>
         <label>
            ANeg Availability:
         <input type="number" name="aneg" onChange={this.handleChange}/>
         </label><br></br>
         <label>
            APoz Availability:
         <input type="number" name="apos" onChange={this.handleChange}/>
         </label><br></br>
         <label>
            BPoz Availability:
         <input type="number" name="bpos" onChange={this.handleChange}/>
         </label><br></br>
         <label>
            BNeg Availability:
         <input type="number" name="bneg" onChange={this.handleChange}/>
         </label><br></br>
         <label>
            ABNeg Availability:
         <input type="number" name="abneg" onChange={this.handleChange}/>
         </label><br></br>
         <label>
            ABPoz Availability:
         <input type="number" name="abpos" onChange={this.handleChange}/>
         </label><br></br>
         <label></label>
         <input type="submit" value="submit" value="POST"/>
        </form>  
        </div>
          
        );
    }
}

export default DonorRegister;


