const requireComponent = require.context('./', true, /\.vue$/)

const components = []

requireComponent.keys().forEach(fileName =>
    {
        const componentConfig = requireComponent(fileName)

        const componentName = fileName
        .split('/')
        .pop()
        .replace(/\.\w+$/, '')

        components[componentName] = componentConfig.default || componentConfig; 
    })
export default components;