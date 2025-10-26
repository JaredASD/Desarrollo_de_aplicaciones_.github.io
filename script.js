// Animar secciones al hacer scroll
const fadeElements = document.querySelectorAll('.fade-in');

const observer = new IntersectionObserver((entries) => {
  entries.forEach(entry => {
    if (entry.isIntersecting) {
      entry.target.classList.add('visible');
    }
  });
}, { threshold: 0.2 });

fadeElements.forEach(el => observer.observe(el));
// Mostrar/ocultar resumen con animación
const toggleButtons = document.querySelectorAll('.toggle-btn');
toggleButtons.forEach(btn => {
  btn.addEventListener('click', () => {
    const summary = btn.nextElementSibling;
    summary.classList.toggle('show');
    btn.textContent = summary.classList.contains('show')
      ? 'Ocultar resumen'
      : 'Ver resumen';
  });
});
const bubbleContainer = document.querySelector('.bubbles');

for (let i = 0; i < 40; i++) {
  const span = document.createElement('span');
  span.style.setProperty('--i', Math.random() * 10 + 1);
  span.style.left = Math.random() * 100 + 'vw'; // posición horizontal aleatoria
  span.style.width = span.style.height = Math.random() * 20 + 10 + 'px'; // tamaños variados
  bubbleContainer.appendChild(span);
}
