const constants = {
    title: [
        {
            value: 'mr',
            label: 'Mr',
        },
        {
            value: 'mrs',
            label: 'Mrs',
        },
        {
            value: 'miss',
            label: 'Miss',
        },
        {
            value: 'ms',
            label: 'Ms',
        },
        {
            value: 'dr',
            label: 'Dr',
        }],
    question: [
        {
            value: 1,
            label: "What is your mother's maiden name?"
        },
        {
            value: 2,
            label: "What is your childhood School name?"
        },
        {
            value: 3,
            label: "Which place you like visiting again & again?"
        },
        {
            value: 4,
            label: "Who is your best friend?"
        },
        {
            value: 5,
            label: "What is your pet name?"
        }],
    menuItems:
        {
            links: [{
                text: 'Home',
                name: 'home',
                link: '/CCSBI',
            }, {
                text: 'About us',
                name: 'aboutus',
                link: '',
                submenu: [{
                    text: 'About us',
                    link: '/CCSBI/AboutUs'
                }, {
                    text: 'What we do',
                    link: '/CCSBI/WhatWeDo'
                }, {
                    text: 'Team',
                    link: '/CCSBI/Team'
                }, {
                    text: 'Pricing',
                    link: '/CCSBI/Pricing'
                }, {
                    text: 'FAQs',
                    link: '/CCSBI/FAQ'
                }]
            }, {
                text: 'Services',
                name: 'services',
                link: '/CCSBI/',
                submenu: [{
                    text: 'Educational Support Services',
                    link: "/CCSBI/EducationSupport"
                }, {
                    text: 'Care Support Services',
                    link: "/CCSBI/CareSupport"
                }, {
                    text: 'Business Support Services',
                    link: "/CCSBI/BusinessSupport"
                }, {
                    text: 'Operations Management',
                    link: "/CCSBI/OperationManagement"
                }, {
                    text: 'Information Tech Services',
                    link: "/CCSBI/InformationTech"
                }]
            }, {
                text: 'Our partners',
                name: 'ourpartners',
                link: '/CCSBI/',
                submenu: [{
                    text: 'Citizens',
                    link: "/CCSBI/Citizen"
                }, {
                    text: 'Small businesses',
                    link: "/CCSBI/SmallBusiness"
                }, {
                    text: 'CCSBI Families',
                    link: "/CCSBI/CCSBIFamilies"
                }, {
                    text: 'Franchises',
                    link: "/CCSBI/Franchises"
                }, {
                    text: 'Other stakeholders',
                    link: "/CCSBI/Stakeholders"
                }]
            }, {
                text: 'Service & Product Search',
                name: 'search',
                link: '/CCSBI/',
                submenu: [{
                    text: 'Service & Product Search',
                    link: "/CCSBI/ServicesProdSearch"
                }, {
                    text: 'Our approach',
                    link: "/CCSBI/OurApproach"
                }, {
                    text: 'Help: How it Works',
                    link: "/CCSBI/Help"
                }, {
                    text: 'Write your need',
                    link: "/CCSBI/WriteToUs"
                }, {
                    text: 'Additional information',
                    link: "/CCSBI/AdditionalInfo"
                }]
            },{
                text: 'Charity Options',
                name: 'charityoptions',
                link: "/CCSBI/CharityOptions"
            }, {
                text: 'Opinion polls',
                name: 'opinionpolls',
                link: "/CCSBI/OpinionPolls"
            }, {
                text: 'Contact us',
                name: 'contactus',
                link: "/CCSBI/.footer-barContactUs"
            }
            ]
        },
    rightMenu:
        {
            items: {
                text: 'Menu Details'
            }
        }


};
export default constants;